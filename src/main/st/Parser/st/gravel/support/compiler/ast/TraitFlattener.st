(reader defineClass: 'TraitFlattener' superclass: 'st.gravel.lang.Object')
!
(reader addInstVar: 'start' type: 'SystemNode')
!
(reader addInstVar: 'intermediate' type: 'SystemNode')
!
(reader addInstVar: 'done' type: 'Set[Reference]')
!
(reader addInstVar: 'todo' type: 'Set[Reference]')
!
(reader addMethod: 'As yet unclassified')
!
flattenTodos {^Self}
	done addAll: todo.
	intermediate := SystemNode
				classDescriptionNodes: (intermediate classDescriptionNodes collect: 
							[:each {ClassDescriptionNode} |
							(todo includes: each reference)
								ifTrue: [each flattenTraitsIn: intermediate]
								ifFalse: [each]])
				namespaceNodes: start namespaceNodes
!
(reader addMethod: 'As yet unclassified')
!
flattenTraits {^SystemNode}
	intermediate := start.
	done := Set new.
	
	[self selectFlattenables.
	todo isEmpty] whileFalse: [self flattenTodos].
	self validate.
	^intermediate
!
(reader addMethod: 'initialize-release')
!
initializeStart: aSystemNode {SystemNode} {^Self}
	start := aSystemNode.
	self initialize
!
(reader addMethod: 'As yet unclassified')
!
selectFlattenables {^Self}
	todo := Set new.
	intermediate classDescriptionNodes do: 
			[:each {ClassDescriptionNode} |
			((done includes: each reference) not and: 
					[each traitUsage prerequisiteReferences allSatisfy: [:pr {Reference} | done includes: pr]])
				ifTrue: [todo add: each reference]]
!
(reader addMethod: 'accessing')
!
start {^SystemNode}
	^start
!
(reader addMethod: 'As yet unclassified')
!
validate {^Self}
	| unflattenable {PSet[Reference]} |
	unflattenable := intermediate classDescriptionNodes keys
				select: [:each {Reference} | (done includes: each) not].
	unflattenable isEmpty
		ifFalse: [self error: 'Unflattenable traits found: ' , unflattenable asArray printString].
	^self
!
(reader addClassMethod: 'instance creation')
!
start: aSystemNode {SystemNode} {^TraitFlattener}
	^self new initializeStart: aSystemNode
!
